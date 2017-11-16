package xFactor.infrastructure.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xFactor.infrastructure.model.Judge;

@Repository
@Transactional
public class JudgeDao extends BaseDao<Judge> {
}