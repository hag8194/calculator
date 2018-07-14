package com.giordano.hugo.calculator.util;

import android.support.annotation.NonNull;

public final class StringUtil {
    public static boolean isNotEmpty(@NonNull CharSequence charSequence) {
        return charSequence.length() > 0;
    }

    public static boolean isEmpty(@NonNull CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    public static boolean isNotNullAndIsNotEmpty(CharSequence charSequence) {
        return charSequence != null && isNotEmpty(charSequence);
    }
}
