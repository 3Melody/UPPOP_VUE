package com.example.demo.contoller;

import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    // Create
    @PostMapping
    public ResponseEntity<Image> createImage(@RequestBody Image image) {
        Image savedImage = imageRepository.save(image);
        return ResponseEntity.ok(savedImage);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageRepository.findAll();
        return ResponseEntity.ok(images);
    }

    // Read One
    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        return imageOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Long id, @RequestBody Image updatedImage) {
        if (!imageRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedImage.setId(id);
        Image savedImage = imageRepository.save(updatedImage);
        return ResponseEntity.ok(savedImage);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        if (!imageRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        imageRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
