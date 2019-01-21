package com.backend.tasks.repository;

import com.backend.tasks.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByName(String name);


    @Query("SELECT t FROM  organization_divisions k WHERE k.following_id = t.owner_id AND k.account_ID = :account_ID AND k.following_id IN (SELECT following_ID FROM account_following WHERE account_id = :account_ID) ORDER BY unixdate DESC")
    public List<Organization> generateTimeLine(Long orgId);
}
