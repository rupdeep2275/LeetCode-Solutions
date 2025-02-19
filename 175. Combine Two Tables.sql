select firstName, lastName, city, state
from person
left join address
on person.personId = address.personId;

# Write your MySQL query statement below
SELECT firstName, lastName, city, state
FROM person
LEFT JOIN address
USING (personId);
