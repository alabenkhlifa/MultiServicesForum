package tn.esprit.MultiServicesForum.presentation.mbeans;

import java.io.ByteArrayInputStream;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import tn.esprit.MultiServicesForum.services.ChallengesServices;

@ManagedBean
@RequestScoped
public class ChallengeImageBean {

			private StreamedContent image;

			@ManagedProperty("#{param.id}")
			private int id;

			@ManagedProperty("#{helperBean.defaultPicture}")
			private byte[] defaultPicture;

			@EJB
			private ChallengesServices local;

			@PostConstruct
			public void init() {
				if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
					// So, we're rendering the view. Return a stub StreamedContent so
					// that it will generate right URL.
					image = new DefaultStreamedContent();
				} else {
					// So, browser is requesting the image. Return a real
					// StreamedContent with the image bytes.
					byte[] productPicture = local.findPictureByChallengeId(id);
					if (productPicture == null) {
						image = new DefaultStreamedContent(new ByteArrayInputStream(
								defaultPicture));
					} else {
						image = new DefaultStreamedContent(new ByteArrayInputStream(
								productPicture));
					}
				}
			}

			public StreamedContent getImage() {
				return image;
			}

			public void setImage(StreamedContent image) {
				this.image = image;
			}

			public byte[] getDefaultPicture() {
				return defaultPicture;
			}

			public void setDefaultPicture(byte[] defaultPicture) {
				this.defaultPicture = defaultPicture;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}
	

}
