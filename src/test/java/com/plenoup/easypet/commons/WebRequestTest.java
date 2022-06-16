package com.plenoup.easypet.commons;

import org.springframework.web.context.request.WebRequest;

import java.security.Principal;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class WebRequestTest implements WebRequest {

    private WebRequestTest() {
    }

    public static WebRequest getWebRequest() {
        return new WebRequestTest();
    }

    @Override
    public String getHeader(final String s) {
        return null;
    }

    @Override
    public String[] getHeaderValues(final String s) {
        return new String[0];
    }

    @Override
    public Iterator<String> getHeaderNames() {
        return null;
    }

    @Override
    public String getParameter(final String s) {
        return null;
    }

    @Override
    public String[] getParameterValues(final String s) {
        return new String[0];
    }

    @Override
    public Iterator<String> getParameterNames() {
        return null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return null;
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public String getContextPath() {
        return null;
    }

    @Override
    public String getRemoteUser() {
        return null;
    }

    @Override
    public Principal getUserPrincipal() {
        return null;
    }

    @Override
    public boolean isUserInRole(final String s) {
        return false;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public boolean checkNotModified(final long l) {
        return false;
    }

    @Override
    public boolean checkNotModified(final String s) {
        return false;
    }

    @Override
    public boolean checkNotModified(final String s, final long l) {
        return false;
    }

    @Override
    public String getDescription(final boolean b) {
        return null;
    }

    @Override
    public Object getAttribute(final String s, final int i) {
        return null;
    }

    @Override
    public void setAttribute(final String s, final Object o, final int i) {

    }

    @Override
    public void removeAttribute(final String s, final int i) {

    }

    @Override
    public String[] getAttributeNames(final int i) {
        return new String[0];
    }

    @Override
    public void registerDestructionCallback(final String s, final Runnable runnable, final int i) {

    }

    @Override
    public Object resolveReference(final String s) {
        return null;
    }

    @Override
    public String getSessionId() {
        return null;
    }

    @Override
    public Object getSessionMutex() {
        return null;
    }
}