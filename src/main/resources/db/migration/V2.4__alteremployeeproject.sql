alter table `Employee_project`
add constraint fk_employee_project_employee_id
foreign key (Employee_ID)
references Employee(Employee_ID);

alter table `Employee_project`
add constraint fk_employee_project_project_id
foreign key (Project_ID)
references Project(Project_ID);