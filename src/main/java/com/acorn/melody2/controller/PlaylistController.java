package com.acorn.melody2.controller;

import com.acorn.melody2.entity.Playlist;
import com.acorn.melody2.service.PlaylistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {
    private static final Logger logger = LoggerFactory.getLogger(PlaylistController.class);

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        logger.warn("playlist: {}", playlist);
        Playlist savePlaylist = playlistService.savePlaylist(playlist);
        return new ResponseEntity<>(savePlaylist, HttpStatus.CREATED);
    }



}