1. /api/v1/customer -- customer related endpoints
   1. POST /auth/signup -- signup the register
   2. POST /auth/login -- login the user -- jwt
   3. POST /ticket -- submit a ticket
   4. GET /ticket -- all ticket
   5. GET /ticket/{id} -- specified ticket
   6. UPDATE /acc/{id} -- update the account
   7. DELETE /acc/{id} -- delete the account
   8. POST /ticket/{id}/note -- create a note
   9. UPDATE /ticket/{id}/note/{id} -- upadte the note
   10. GET /ticket/{id}note -- all notes related to one ticket
   11. POST /ticket/{id}/file -- post a file
   12. POST /ticket/{id}/feedback -- submit a feedback
   13. GET /ticket/{id}/feedback -- get the feedbacks

- customer:
  id
  firstName
  lastName
  email
  password
  createdAt
  modifiedAt

- ticket:
  id
  title
  content
  customer_id (foreign_key)
  createAt
  modifiedAt

- ticket_notes:
  id
  ticket_id
  content
  createdAt
  modifiedAt

- ticket_files:
  id
  ticket_id
  file_url
  createdAt

- keywords:
  id
  parent_id (foriegn key to itself)
  name
  description
  createdAt
  modifiedAt

- ticket_keywords:
  id
  ticket_id
  keyword_id

- ticket_staff:
  id
  ticket_id
  staff_id
  status (active, passive)
  assignedAt
  disposalAt

- staff
  id
  firstName
  lastName
  email
  password

- staff_keyword
  id
  staff_id
  keyword_id
