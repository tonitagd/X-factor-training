package xFactor.infrastructure.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xFactor.infrastructure.model.Vote;

@Repository
@Transactional
public class VoteDao extends BaseDao<Vote> {
}