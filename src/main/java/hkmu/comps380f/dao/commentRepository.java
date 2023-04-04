package hkmu.comps380f.dao;

import hkmu.comps380f.model.comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface commentRepository extends JpaRepository<comment, Long> {
}
