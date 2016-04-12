CREATE TABLE flight
(
  "number" text,
  arivalairport text,
  id serial NOT NULL,
  depdate date,
  departureairport text,
  price int,
  seats int,
  deptime time,
  CONSTRAINT flight_pkey PRIMARY KEY (id)
)
