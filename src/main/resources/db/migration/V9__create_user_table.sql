CREATE TABLE `User` (
    Username varchar(64) NOT NULL,
    Password varchar(64) NOT NULL,
    RoleId TINYINT NOT NULL,
    PRIMARY KEY (Username),
    FOREIGN KEY (RoleId) REFERENCES Role(RoleId)
)

INSERT INTO User(Username, Password, RoleId) VALUES ('HR', 'HR', 1);
INSERT INTO User(Username, Password, RoleId) VALUES ('Management', 'Management', 2);
