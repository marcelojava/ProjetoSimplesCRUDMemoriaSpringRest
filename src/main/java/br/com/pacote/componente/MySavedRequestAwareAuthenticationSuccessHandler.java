package br.com.pacote.componente;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

public class MySavedRequestAwareAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		SavedRequest savedRequest = this.requestCache.getRequest(request, response);

		if (Objects.isNull(savedRequest)) {
			clearAuthenticationAttributes(request);
			return;
		}

		String targetUrlParam = getTargetUrlParameter();

		if (isAlwaysUseDefaultTargetUrl()
				|| (Objects.nonNull(targetUrlParam) && StringUtils.hasText(request.getParameter(targetUrlParam)))) {
			this.requestCache.removeRequest(request, response);
			clearAuthenticationAttributes(request);
			return;
		}

		clearAuthenticationAttributes(request);

	}

	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}
}
