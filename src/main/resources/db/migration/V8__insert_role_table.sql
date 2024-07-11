CREATE TABLE `SystemRole` (
    RoleId TINYINT NOT NULL,
    Name varchar(64) NOT NULL,
    PRIMARY KEY (RoleId)
);

INSERT INTO SystemRole(RoleId, Name) VALUES (1, 'HR');
INSERT INTO SystemRole(RoleId, Name) VALUES (2, 'Management');