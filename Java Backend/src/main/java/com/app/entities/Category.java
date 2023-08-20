package com.app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "categories")


public class Category {
		
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long cat_id;

	    @NotBlank(message = "Category name is required")
	    @Size(max = 100, message = "Category name can't exceed 100 characters")
	    private String cat_name;

	    @Size(max = 1000, message = "Category description can't exceed 1000 characters")
	    private String cat_desc;

	    // Relationships (if needed)
	     @OneToMany(mappedBy = "category")
	     private List<Service> services;

		public Category() {
			super();
		}

		public Category(Long cat_id,
				@NotBlank(message = "Category name is required") @Size(max = 100, message = "Category name can't exceed 100 characters") String cat_name,
				@Size(max = 1000, message = "Category description can't exceed 1000 characters") String cat_desc,
				List<Service> services) {
			super();
			this.cat_id = cat_id;
			this.cat_name = cat_name;
			this.cat_desc = cat_desc;
			this.services = services;
		}

		public Long getCat_id() {
			return cat_id;
		}

		public void setCat_id(Long cat_id) {
			this.cat_id = cat_id;
		}

		public String getCat_name() {
			return cat_name;
		}

		public void setCat_name(String cat_name) {
			this.cat_name = cat_name;
		}

		public String getCat_desc() {
			return cat_desc;
		}

		public void setCat_desc(String cat_desc) {
			this.cat_desc = cat_desc;
		}

		public List<Service> getServices() {
			return services;
		}

		public void setServices(List<Service> services) {
			this.services = services;
		}

		@Override
		public String toString() {
			return "Category [cat_id=" + cat_id + ", cat_name=" + cat_name + ", cat_desc=" + cat_desc + ", services="
					+ services + "]";
		}
	     
		
}
