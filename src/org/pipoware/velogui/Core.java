package org.pipoware.velogui;

/**
 * Title:        VeloGUI
 * Description:  A Graphic User Interface for testing velocity scripts whithout writing code.
 * Copyright:    Copyright (c) 2002
 * Company:      Pipoware.org
 * @author Franck Arnulfo
 * @version 1.0
 */

import bsh.Interpreter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.runtime.RuntimeConstants;

import java.io.StringWriter;

public class Core {

    VelocityEngine m_ve;

    public Core() throws Exception {
        m_ve = new VelocityEngine();

        m_ve.setProperty( RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
                "org.apache.velocity.runtime.log.NullLogSystem" );
//        m_ve.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
        m_ve.init();
    }

    public String getMerge(String beanshellScript, String velocityScript) {
        String mergedText;
        try
        {
            Interpreter interpreter = new Interpreter();
            VelocityContext context = new VelocityContext();
            interpreter.set("context", context);
            interpreter.eval(beanshellScript);
            context = (VelocityContext)interpreter.get("context");
            StringWriter w = new StringWriter();
            m_ve.evaluate(context, w, "inlineTemplate", velocityScript);
            mergedText = w.toString();
        } catch(ParseErrorException pee)
        {
            mergedText = "ParseErrorException : ".concat(String.valueOf(String.valueOf(pee)));
            pee.printStackTrace();
        }
        catch(MethodInvocationException mee)
        {
            mergedText = "MethodInvocationException : ".concat(String.valueOf(String.valueOf(mee)));
            mee.printStackTrace();
        } catch(Exception eee)
        {
            mergedText = eee.toString();
            eee.printStackTrace();
        }

        return mergedText;
    }
}