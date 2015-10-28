CREATE TABLE responsible (
    responsible_id serial NOT NULL,
    name CHARACTER VARYING(100) NOT NULL,
    login CHARACTER VARYING(25),
    password CHARACTER VARYING,
    email CHARACTER VARYING(120),
    active BOOLEAN,
    CONSTRAINT responsible_pkey PRIMARY KEY(responsible_id)
);
CREATE TABLE computer (
    computer_id SERIAL NOT NULL,
    name CHARACTER VARYING(100) NOT NULL,
    motherboard CHARACTER VARYING(25),
    hard_disk CHARACTER VARYING,
    processor CHARACTER VARYING(155),
    operational_system CHARACTER VARYING(155),
    memory_ram CHARACTER VARYING(120),
    usb_enable BOOLEAN,
    active BOOLEAN,
    CONSTRAINT computer_pkey PRIMARY KEY(computer_id)
);
CREATE TABLE computer_user (
    user_id serial NOT NULL,
    name CHARACTER VARYING(100) NOT NULL,
    area CHARACTER VARYING(25),
    phone CHARACTER VARYING(25),
    mail CHARACTER VARYING(100),
    active BOOLEAN,
    CONSTRAINT user_pkey PRIMARY KEY(user_id)
);
CREATE TABLE computer_responsible (
    computer_id SERIAL NOT NULL,
    responsible_id SERIAL NOT NULL,
    PRIMARY KEY(computer_id, responsible_id),
    CONSTRAINT fk_computer_responsible_computer
        FOREIGN KEY(computer_id)
        REFERENCES computer(computer_id),
    CONSTRAINT fk_computer_responsible_responsible
        FOREIGN KEY(responsible_id)
        REFERENCES responsible(responsible_id)
);
CREATE TABLE user_support (
    support_id SERIAL NOT NULL,
    computer_id SERIAL NOT NULL,
    user_id SERIAL NOT NULL,
    description CHARACTER VARYING(255),
    inserted_at DATE,
    status SMALLINT,
    CONSTRAINT support_pkey PRIMARY KEY(support_id),
    CONSTRAINT fk_computer_support_computer
        FOREIGN KEY(computer_id)
        REFERENCES computer(computer_id),
    CONSTRAINT fk_computer_support_user
        FOREIGN KEY(user_id)
        REFERENCES computer_user(user_id)
);
INSERT INTO responsible VALUES (1, 'Ronaldo', 'Ronaldo', '123', 'ronaldo@email.com', true);
INSERT INTO computer VALUES (1, 'Computador I', 'ASUS', '500 Gb', 'Intel I7', 'Windows 8', '12 Gb', true, true);
INSERT INTO computer VALUES (2, 'Computador II', 'INTEL', '250 Gb', 'Intel I5', 'Windows 10', '7 Gb', true, true);
INSERT INTO computer_user VALUES (1, 'Zidane', 'Financeiro', '9999999999', 'zidane@email.com', true);
INSERT INTO computer_responsible VALUES (1, 1);
INSERT INTO user_support VALUES (1, 1, 1, 'Google não funciona, favor solucionar', '2015-10-26', 1);
