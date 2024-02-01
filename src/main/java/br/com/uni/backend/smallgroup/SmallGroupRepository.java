package br.com.uni.backend.smallgroup;

import br.com.uni.backend.smallgroup.model.SmallGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SmallGroupRepository extends JpaRepository<SmallGroup, Long> {
}
