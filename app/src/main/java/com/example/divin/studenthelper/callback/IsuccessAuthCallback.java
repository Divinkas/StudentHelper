package com.example.divin.studenthelper.callback;

import javax.security.auth.callback.Callback;

public interface IsuccessAuthCallback extends Callback {
    void resultAuthentication(boolean isValid);
}
