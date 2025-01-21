CREATE TABLE freelancer_skills(
    freelancer_id UUID NOT NULL,
    skill_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    PRIMARY KEY (freelancer_id, skill_id),
    FOREIGN KEY (freelancer_id) REFERENCES freelancer(id) ON DELETE CASCADE, 
    FOREIGN KEY (skill_id) REFERENCES skill(id) ON DELETE CASCADE
);