package restApi;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the organization_addresses database table.
 * 
 */
@Entity
@Table(name="organization_addresses")
@NamedQuery(name="OrganizationAddress.findAll", query="SELECT o FROM OrganizationAddress o")
public class OrganizationAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrganizationAddressPK id;

	@Column(name="address_type_code")
	private String addressTypeCode;

	@Temporal(TemporalType.DATE)
	@Column(name="date_address_to")
	private Date dateAddressTo;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Addresses_address_id")
	private Address address;

	//bi-directional many-to-one association to Organization
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Organizations_organization_id")
	private Organization organization;

	public OrganizationAddress() {
	}

	public OrganizationAddressPK getId() {
		return this.id;
	}

	public void setId(OrganizationAddressPK id) {
		this.id = id;
	}

	public String getAddressTypeCode() {
		return this.addressTypeCode;
	}

	public void setAddressTypeCode(String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	public Date getDateAddressTo() {
		return this.dateAddressTo;
	}

	public void setDateAddressTo(Date dateAddressTo) {
		this.dateAddressTo = dateAddressTo;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}