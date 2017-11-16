package xFactor.infrastructure.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xFactor.infrastructure.model.Participant;

@Repository
@Transactional
public class ParticipantDao extends BaseDao<Participant> {
}