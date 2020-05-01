--;;
CREATE TABLE phone(
    id         INTEGER PRIMARY KEY,
    phone      TEXT    NOT NULL UNIQUE,
    contact_id INTEGER NOT NULL,
    FOREIGN KEY (contact_id) REFERENCES contact (id)
);
--;;
CREATE INDEX idx_contact_phone_id ON phone (contact_id)
