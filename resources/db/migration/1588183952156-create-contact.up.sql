--;;
CREATE TABLE contact (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    phone_id INTEGER NOT NULL,
    FOREIGN KEY (phone_id) REFERENCES phone (id)
);
--;;
CREATE INDEX idx_contact_phone_id ON contact (phone_id)
