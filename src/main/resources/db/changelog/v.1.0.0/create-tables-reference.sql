ALTER TABLE car
ADD CONSTRAINT fk_cars_person FOREIGN KEY (person_id) REFERENCES person (id);
ALTER TABLE passport
ADD CONSTRAINT fk_passport_person FOREIGN KEY (person_id) REFERENCES person (id);
ALTER TABLE ref_person_house
ADD CONSTRAINT fk_houses_persons FOREIGN KEY (house_id) REFERENCES house (id);
ALTER TABLE ref_person_house
ADD CONSTRAINT fk_persons_house FOREIGN KEY (person_id) REFERENCES person (id);
ALTER TABLE ref_person_house
ADD CONSTRAINT uni_person_house_id UNIQUE (house_id,person_id);