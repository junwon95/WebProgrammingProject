CREATE EXTENSION IF NOT EXISTS dblink;

DO $$
    BEGIN
        PERFORM dblink_exec('', 'CREATE DATABASE webp');
    EXCEPTION WHEN duplicate_database THEN RAISE NOTICE '%, skipping', SQLERRM USING ERRCODE = SQLSTATE;
    END
$$;
