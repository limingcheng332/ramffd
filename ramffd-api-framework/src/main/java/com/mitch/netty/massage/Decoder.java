package com.mitch.netty.massage;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface Decoder<T extends Message> {
     T decode(String message);

      String encode(T message);
}
