-- INSERT EMPLOYEES			
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'John', 'Warton', 'warton@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Mike', 'Lanister', 'lanister@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Steve', 'Reeves', 'Reeves@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Ronald', 'Connor', 'connor@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Jim', 'Salvator', 'Sal@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Peter', 'Henley', 'henley@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Richard', 'Carson', 'carson@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Honor', 'Miles', 'miles@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Tony', 'Roggers', 'roggers@gmail.com');

-- INSERT PROJECTS			
insert into project (project_id, name, stage, description, start_date, end_date) values (nextval('project_seq'), 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production', '1980-01-01', '2005-01-01');
insert into project (project_id, name, stage, description, start_date, end_date) values (nextval('project_seq'), 'New Employee Budget',  'COMPLETED', 'Decide on a new employee bonus budget for the year and figureout who will be promoted', '1978-02-05', '2003-01-01');
insert into project (project_id, name, stage, description, start_date, end_date) values (nextval('project_seq'), 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed', '1975-01-01', '2001-01-01');
insert into project (project_id, name, stage, description, start_date, end_date) values (nextval('project_seq'), 'Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation', '2000-01-01', '2017-03-01');

-- INSERT PROJECT_EMPLOYEE_RELATION
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Reeves' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Improve Intranet Security');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Henley' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Henley' AND p.name = 'Improve Intranet Security');