INSERT INTO Event (ID,CURRENT,YEAR) VALUES (7, TRUE ,2017);
UPDATE Event SET CURRENT=FALSE WHERE ID=6;
UPDATE Event set day1=1461218400000, day2=1461304800000 where id = 7;

INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5032, 7, 'GOLD');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5033, 7, 'GOLD');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5034, 7, 'GOLD');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5035, 7, 'GOLD');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5036, 7, 'GOLD');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5037, 7, 'GOLD');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5038, 7, 'GOLD');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5039, 7, 'GOLD');

INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5032, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5033, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5034, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5035, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5036, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5037, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5038, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5039, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5040, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5041, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5042, 7, 'SILVER');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5043, 7, 'SILVER');

INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5032, 7, 'LANYARD');

INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5032, 7, 'PARTY');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5033, 7, 'PARTY');

INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5032, 7, 'BREAKFAST');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5033, 7, 'BREAKFAST');

INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5032, 7, 'LUNCH');
INSERT INTO MemberEvent (MEMBER_ID, EVENT_ID, LEVEL) VALUES(5033, 7, 'LUNCH');