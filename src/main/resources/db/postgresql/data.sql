INSERT INTO specialties VALUES (1, 'radiology') ON CONFLICT (id) DO NOTHING;
INSERT INTO specialties VALUES (2, 'surgery') ON CONFLICT (id) DO NOTHING;
INSERT INTO specialties VALUES (3, 'dentistry') ON CONFLICT (id) DO NOTHING;

INSERT INTO vets VALUES (1, 'James','',1, 1) ON CONFLICT (id) DO NOTHING;

INSERT INTO owners VALUES (1, 'George') ON CONFLICT (id) DO NOTHING;
INSERT INTO members VALUES (1, 'test', '123', 'junwonseo95@gmail.com', 'VET') ON CONFLICT (id) DO NOTHING;

INSERT INTO pets VALUES (1, 'Leo', '2000-09-07', 'cat', 1) ON CONFLICT (id) DO NOTHING;

INSERT INTO visits VALUES (1, 1, '2010-03-04', 'rabies shot') ON CONFLICT (id) DO NOTHING;