package com.example.mainapplication.data.repository;

public interface RepositoryCallback<T>
{
    void onComplete(Result<T> result);
}
