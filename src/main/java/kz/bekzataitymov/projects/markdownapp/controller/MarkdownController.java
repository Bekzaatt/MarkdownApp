package kz.bekzataitymov.projects.markdownapp.controller;

import kz.bekzataitymov.projects.markdownapp.model.Markdown;
import kz.bekzataitymov.projects.markdownapp.service.MarkdownService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MarkdownController {
    private final MarkdownService markdownService;

    @GetMapping("/markdown")
    public List<Markdown> getAllNotes() {
        return this.markdownService.getAllNotes();
    }

    @GetMapping("/markdown/{id}")
    public String getNoteById(@PathVariable String id) {
        return this.markdownService.getNoteById(id);
    }

    @PostMapping("/markdown")
    public String uploadNote(@RequestBody String text) {
        return this.markdownService.save(text);
    }

    @PostMapping("/markdown/file")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile){
        return this.markdownService.saveFile
    }
}
