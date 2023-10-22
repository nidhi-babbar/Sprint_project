

INSERT INTO retrospective(retrospective_id,name, summary,date)
VALUES(1,'Retrospective 1', 'Post release retrospective','1984-12-17');

INSERT INTO participants(retrospective_id,participant)
VALUES(1,'Nidhi');
INSERT INTO participants(retrospective_id,participant)
VALUES(1,'Rajiv');

INSERT INTO feedback(id, name, body, type,retro_id) VALUES(1, 'Gareth', 'Sprint objective met', 'POSITIVE',1);
INSERT INTO feedback(id, name, body, type,retro_id) VALUES(2, 'Viktor', 'Too many items piled up in the awaiting QA', 'NEGATIVE',1);
INSERT INTO feedback(id, name, body, type,retro_id) VALUES(3, 'Mike', 'We should be looking to start using VS2015', 'IDEAL',1);


