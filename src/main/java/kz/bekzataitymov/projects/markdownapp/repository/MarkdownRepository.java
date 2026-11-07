package kz.bekzataitymov.projects.markdownapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import kz.bekzataitymov.projects.markdownapp.model.Markdown;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarkdownRepository {
    private final EntityManager entityManager;

    public List<Markdown> getAllNotes() {
        TypedQuery<Markdown> query = this.entityManager.createQuery("SELECT m FROM Markdown m", Markdown.class);
        return query.getResultList();
    }

    public Markdown save(Markdown markdown) {
        this.entityManager.persist(markdown);
        return markdown;
    }

    public Markdown getById(String id) {
        return this.entityManager.find(Markdown.class, id);
    }
}
