INSERT INTO specialties VALUES (1, '영상의학') ON CONFLICT (id) DO NOTHING;
INSERT INTO specialties VALUES (2, '수술전문') ON CONFLICT (id) DO NOTHING;
INSERT INTO specialties VALUES (3, '치과의사') ON CONFLICT (id) DO NOTHING;

INSERT INTO vets VALUES (11, '동국이','동국대 출신 의사',11, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO vets VALUES (12, '홍길동','길동역에 살고있어요',13, 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO vets VALUES (13, '제임스','한국말 잘 모릅니다.',14, 3) ON CONFLICT (id) DO NOTHING;

INSERT INTO owners VALUES (11, 'George' , 12) ON CONFLICT (id) DO NOTHING;

INSERT INTO members VALUES (11, 'test', '123', 'junwonseo95@gmail.com', 'VET') ON CONFLICT (id) DO NOTHING;
INSERT INTO members VALUES (12, 'test2', '123', 'ssmmttpp123@gmail.com', 'USER') ON CONFLICT (id) DO NOTHING;
INSERT INTO members VALUES (13, 'test3', '123', 'ssmmttpp12@gmail.com', 'VET') ON CONFLICT (id) DO NOTHING;
INSERT INTO members VALUES (14, 'test4', '123', 'ssmmttpp1@gmail.com', 'VET') ON CONFLICT (id) DO NOTHING;

INSERT INTO pets VALUES (11, '멍멍이', '2000-09-07', '개', 11) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (12, '초이', '2000-09-07', '고양이', 11) ON CONFLICT (id) DO NOTHING;

INSERT INTO visits VALUES (11, 11, 11, '2010-03-04', '배가 아파요') ON CONFLICT (id) DO NOTHING;
INSERT INTO visits VALUES (12, 12, 11, '2010-01-04', '머리가 아파요') ON CONFLICT (id) DO NOTHING;
INSERT INTO visits VALUES (13, 11, 11, '2010-01-04', '뚱뚱해요') ON CONFLICT (id) DO NOTHING;

INSERT INTO treatments VALUES (11, 11, 11, '할미손이 약손', '복통약 처방') ON CONFLICT (id) DO NOTHING;
