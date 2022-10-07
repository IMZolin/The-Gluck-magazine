alter table if exists user
    add constraint if not exists uq_email unique(email);