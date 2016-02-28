INSERT INTO public.login_details(user_id, enabled, password, user_name) VALUES (1, true, '21232f297a57a5a743894a0e4a801fc3', 'anil');
INSERT INTO public.soc_user( user_id, address, email_id, end_date, first_name, is_owner, last_name, middle_name, no_of_members, pan_no, phone_no, start_date)
    VALUES (1, 'Bella Casa', 'team@mail.com', null, 'Anil', 'Owner', 'Kumar', 'L', '4', 'BVWPK2688A', '8087333924', null);
INSERT INTO public.user_role(user_role_id, role, userid) VALUES (1, 'ROLE_USER', 1);

Select * from public.login_details;
Select * from public.soc_user;
Select * from public.user_role;
