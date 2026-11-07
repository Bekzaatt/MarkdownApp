package kz.bekzataitymov.projects.markdownapp.service;

import jakarta.transaction.Transactional;
import kz.bekzataitymov.projects.markdownapp.model.Markdown;
import kz.bekzataitymov.projects.markdownapp.repository.MarkdownRepository;
import lombok.RequiredArgsConstructor;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkdownService {
    private final MarkdownRepository markdownRepository;
    private final RenderHtmlService htmlRenderer;

    public List<Markdown> getAllNotes() {
        return this.markdownRepository.getAllNotes();
    }

    @Transactional
    public String save(String text) {
        Markdown markdown = Markdown.builder()
                .content(text)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        this.markdownRepository.save(markdown);
        return this.htmlRenderer.renderMarkdownToHtml(text);
    }

    public String getNoteById(String id) {
        Markdown markdown = this.markdownRepository.getById(id);
        return this.htmlRenderer.renderMarkdownToHtml(markdown.getContent());
    }
}
