
package simulation.tankGame.util;


import simulation.tankGame.exception.TankBattleGameException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Reflection.
 *
 * @author fengluo
 * @since 2020/10/24
 */
public class RefUtils {

    /**
     * Execution based on method name
     *
     * @param obj            obj
     * @param methodName     methodName
     * @param parameterTypes parameterTypes
     * @param args           args
     * @return Object
     */
    public static Object executeByMethodName(Object obj, String methodName, Class<?>[]
            parameterTypes, Object[] args) {
        try {
            Method func = obj.getClass().getMethod(methodName, parameterTypes);
            return func.invoke(obj, args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new TankBattleGameException("executeByMethodName exception");
        }
    }


    private RefUtils() {
        throw new IllegalStateException("Utility class");
    }
}
