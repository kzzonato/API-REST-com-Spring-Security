CREATE TABLE product (
	id UUID PRIMARY KEY NOT NULL,
	name TEXT NOT NULL,
	price_in_cents INT NOT NULL,
	active BOOLEAN NOT NUll
);