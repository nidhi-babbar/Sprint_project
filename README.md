# Sprint_project

# Get all restrospective
http://localhost:8000/retrospective

# Save  restrospective Post mapping

http://localhost:8000/retrospective
 
{
 
    "name": "Retropective6",
    "summary": "Post release retrospective 6",
    "date":"2023-12-17",
    "participants":["Nidhi","Nitya"]
    
    

}



# Save  Feedback Post mapping

http://localhost:8000/feedback/createFeedback/1   # 1 is the retrospective id 
{
   
    "name":"Nidhi",
    "body": "All stories achieved",
    "type":"POSITIVE"
}


# Update  Feedback put mapping

http://localhost:8000/feedback/updateFeedback/1   # 1 is the retrospective id 
{
    "id":1,
    "name":"Nidhi",
    "body": "All stories achieved thanks",
    "type":"POSITIVE"
}


# Get all restrospective with pagination
http://localhost:8000/retrospective/pagination?pageNo=1&pageSize=1