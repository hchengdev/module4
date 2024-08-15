package org.md3.musicapp.controller;

import org.md3.musicapp.model.Song;
import org.md3.musicapp.model.SongUploadForm;
import org.md3.musicapp.service.SongDAO;
import org.md3.musicapp.service.SongDAOInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    SongDAOInterface songDao = new SongDAO();

    @Value("${file-upload}")
    private String upload;

    @GetMapping
    public String getSongList(Model model) {
        List<Song> songListSong = songDao.getAllSongs();
        model.addAttribute("songList", songListSong);
        return "song/index";
    }

    @GetMapping("/{id}/view")
    public String viewSong(@PathVariable int id, Model model) {
        Song song = songDao.getSongById(id);
        model.addAttribute("song", song);
        return "song/detail";
    }

    @GetMapping("/upload")
    public String uploadForm(Model model) {
        model.addAttribute("uploadForm", new SongUploadForm());
        return "song/upload";
    }

    @PostMapping("/save")
    public ModelAndView saveSong(@ModelAttribute SongUploadForm uploadForm) {
        MultipartFile songFile = uploadForm.getSong();
        String fileName = songFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(uploadForm.getSong().getBytes(), new File(upload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Song song = new Song(uploadForm.getTitle(), uploadForm.getArtist(), uploadForm.getGenre(), fileName);
        songDao.addSong(song);
        ModelAndView mav = new ModelAndView("redirect:/songs");
        mav.addObject("message", "Song added successfully");
        return mav;
    }
}
