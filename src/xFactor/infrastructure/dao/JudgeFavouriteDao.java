package xFactor.infrastructure.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xFactor.infrastructure.model.JudgeFavourite;

@Repository
@Transactional
public class JudgeFavouriteDao extends BaseDao<JudgeFavourite> {
}