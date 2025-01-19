CREATE TABLE client_skills(
    client_id UUID NOT NULL,
    skill_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    PRIMARY KEY (client_id, skill_id),
    FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE, 
    FOREIGN KEY (skill_id) REFERENCES skill(id) ON DELETE CASCADE
);