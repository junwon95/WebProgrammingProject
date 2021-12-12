INSERT INTO specialties VALUES (1, '영상의학') ON CONFLICT (id) DO NOTHING;
INSERT INTO specialties VALUES (2, '수술전문') ON CONFLICT (id) DO NOTHING;
INSERT INTO specialties VALUES (3, '치과의사') ON CONFLICT (id) DO NOTHING;

INSERT INTO vets VALUES (1, '동국이','동국대 출신 의사',1, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO vets VALUES (2, '홍길동','길동역에 살고있어요',3, 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO vets VALUES (3, '제임스','한국말 잘 모릅니다.',4, 3) ON CONFLICT (id) DO NOTHING;

INSERT INTO owners VALUES (1, 'George' , 2) ON CONFLICT (id) DO NOTHING;

INSERT INTO members VALUES (1, 'test', '123', 'junwonseo95@gmail.com', 'VET') ON CONFLICT (id) DO NOTHING;
INSERT INTO members VALUES (2, 'test2', '123', 'ssmmttpp123@gmail.com', 'USER') ON CONFLICT (id) DO NOTHING;
INSERT INTO members VALUES (3, 'test3', '123', 'ssmmttpp12@gmail.com', 'VET') ON CONFLICT (id) DO NOTHING;
INSERT INTO members VALUES (4, 'test4', '123', 'ssmmttpp1@gmail.com', 'VET') ON CONFLICT (id) DO NOTHING;

INSERT INTO pets VALUES (1, '멍멍이', '2000-09-07', '개', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (2, '초이', '2000-09-07', '고양이', 1) ON CONFLICT (id) DO NOTHING;

INSERT INTO visits VALUES (1, 1, 1, '2010-03-04', '배가 아파요') ON CONFLICT (id) DO NOTHING;
INSERT INTO visits VALUES (2, 2, 1, '2010-01-04', '머리가 아파요') ON CONFLICT (id) DO NOTHING;
INSERT INTO visits VALUES (3, 1, 1, '2010-01-04', '뚱뚱해요') ON CONFLICT (id) DO NOTHING;

INSERT INTO treatments VALUES (1, 1, 1, '할미손이 약손', '복통약 처방') ON CONFLICT (id) DO NOTHING;
