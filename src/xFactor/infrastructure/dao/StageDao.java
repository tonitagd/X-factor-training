package xFactor.infrastructure.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xFactor.infrastructure.model.Stage;

@Repository
@Transactional
public class StageDao extends BaseDao<Stage> {
}