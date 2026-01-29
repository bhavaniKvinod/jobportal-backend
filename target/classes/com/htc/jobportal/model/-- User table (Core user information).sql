-- User table (Core user information)
CREATE TABLE user_table (
    user_id BIGINT PRIMARY KEY,
    first_name VARCHAR,
    last_name VARCHAR,
    email VARCHAR UNIQUE NOT NULL,
    password VARCHAR,
    address VARCHAR,
    role VARCHAR,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-- Employer table (Employer-specific information)
CREATE TABLE employer (
    user_id BIGINT PRIMARY KEY REFERENCES user_table(user_id),
    company_name VARCHAR,
    industry VARCHAR,
    location VARCHAR
);

-- Job Seeker table (Job seeker-specific information)
CREATE TABLE job_seeker (
    user_id BIGINT PRIMARY KEY REFERENCES user_table(user_id),
    skills VARCHAR,
    resume_url VARCHAR,
    exp_years INTEGER NOT NULL
);

-- Job table (Job postings)
CREATE TABLE job (
    job_id BIGINT PRIMARY KEY,
    employer_user_id BIGINT REFERENCES employer(user_id),
    title VARCHAR,
    description VARCHAR,
    job_type VARCHAR,
    requirements VARCHAR,
    salary_range VARCHAR,
    status VARCHAR,
    posted_date DATE
);

-- Application table (Job applications)
CREATE TABLE application (
    app_id BIGINT PRIMARY KEY,
    seeker_id BIGINT REFERENCES job_seeker(user_id),
    job_id BIGINT REFERENCES job(job_id),
    status VARCHAR,
    applied_date DATE
);

-- Interview table (Interview scheduling)
CREATE TABLE interview (
    interview_id BIGINT PRIMARY KEY,
    app_id BIGINT REFERENCES application(app_id),
    mode VARCHAR,
    sched_date DATE,
    result VARCHAR,
    feedback VARCHAR
);

-- Token table (JWT token management)
CREATE TABLE token (
    id BIGINT PRIMARY KEY,
    userid BIGINT REFERENCES user_table(user_id),
    jwttoken VARCHAR,
    is_expired BOOLEAN NOT NULL,
    is_revoked BOOLEAN NOT NULL
);