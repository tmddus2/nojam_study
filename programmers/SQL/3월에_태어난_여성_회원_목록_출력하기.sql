SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
from member_profile
where gender='W' and date_of_birth REGEXP ".*-03-.*" and tlno is not null
order by member_id