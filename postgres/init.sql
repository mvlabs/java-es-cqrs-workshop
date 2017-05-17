/* create projections */
CREATE TABLE pizzerias (
  id VARCHAR(36) NOT NULL,
  name VARCHAR(1023) NOT NULL,
  pizzas TEXT[],
  PRIMARY KEY (id),
  UNIQUE (name)
);
