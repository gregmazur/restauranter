package ppl.da.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ppl.da.core.entity.Feedback;

/**
 * Created by greg on 18.10.15.
 */
public interface FeedbackDao extends JpaRepository<Feedback,Long> {
}
