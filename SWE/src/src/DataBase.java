package src;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DataBase implements IDataBase {

	private int ID;
	private List<NormalUser> normalUsers;
	private List<StoreOwner> Storeowners;
	private List<Administrator> Admins;
	private Map<String, List<Product>> categoryProducts;
	private List<Product> Sysproducts;
	private List<Product> suggestedProducts;
	private List<Store> stores;
	private List<String> brands;
	private List<String> vouchercards;

	public DataBase() {
		normalUsers = new ArrayList<>();
		Storeowners = new ArrayList<>();
		Admins = new ArrayList<>();
		suggestedProducts = new ArrayList<>();
		
		
		categoryProducts = new HashMap<>();
		categoryProducts.put("Electronics", new ArrayList<>());
		categoryProducts.put("Clothes", new ArrayList<>());
		categoryProducts.put("Mobile", new ArrayList<>());
		categoryProducts.put("Laptops", new ArrayList<>());
		categoryProducts.put("Shoes", new ArrayList<>());

		Sysproducts = new ArrayList<>();
		stores = new ArrayList<>();
		brands = new ArrayList<>();
		vouchercards = new ArrayList<>();

	}

	public void writeAll() {
		/*
		 * try {
		 * 
		 * for (Map.Entry<String, List<Product>> p :
		 * categoryProducts.entrySet()) { ObjectOutputStream writer = new
		 * ObjectOutputStream(new FileOutputStream(p.getKey() + ".txt"));
		 * writer.writeObject(p.getValue()); writer.close(); } } catch
		 * (IOException e1) { }
		 */

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("IDCounter.txt"));
			out.write(Integer.toString(ID));
			out.close();
		} catch (Exception e) {
		}

		try {
			BufferedWriter file = new BufferedWriter(new FileWriter("Brands.txt"));
			for (String s : brands) {
				file.write(s);
				file.newLine();
			}
			file.close();

		} catch (IOException e) {
		}

		try {
			BufferedWriter file = new BufferedWriter(new FileWriter("VoucherCards.txt"));
			for (String s : vouchercards) {
				file.write(s);
				file.newLine();
			}
			file.close();

		} catch (IOException e) {
		}

		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("NormalUsers.txt"));
			file.writeObject(normalUsers);
			file.close();

		} catch (IOException e) {
		}

		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("StoreOwners.txt"));
			file.writeObject(Storeowners);
			file.close();

		} catch (IOException e) {
		}

		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("Admins.txt"));
			file.writeObject(Admins);
			file.close();

		} catch (IOException e) {
		}

		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("Stores.txt"));
			file.writeObject(stores);
			file.close();

		} catch (IOException e) {
		}

		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("SystemProducts.txt"));
			file.writeObject(Sysproducts);
			file.close();

		} catch (IOException e) {
		}

		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("SuggestedProducts.txt"));
			file.writeObject(suggestedProducts);
			file.close();

		} catch (IOException e) {
		}

		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("Categories_Products.txt"));
			file.writeObject(categoryProducts);
			file.close();

		} catch (IOException e) {
		}

	}

	public void readAll() {

		Path path;

		try {
			BufferedReader reader = new BufferedReader(new FileReader("IDCounter.txt"));
			ID = Integer.parseInt(reader.readLine());
			reader.close();

		} catch (FileNotFoundException e) {
		} catch (IOException e) {

		}

		path = Paths.get("Brands.txt");
		try {
			brands = Files.readAllLines(path);
		} catch (IOException e1) {
		}

		path = Paths.get("VoucherCards.txt");
		try {
			vouchercards = Files.readAllLines(path);
		} catch (IOException e1) {
		}

		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream("NormalUsers.txt"));
			normalUsers = (List<NormalUser>) file.readObject();
			file.close();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}

		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream("StoreOwners.txt"));
			Storeowners = (List<StoreOwner>) file.readObject();
			file.close();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}

		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream("Admins.txt"));
			Admins = (List<Administrator>) file.readObject();
			file.close();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}

		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream("Stores.txt"));
			stores = (List<Store>) file.readObject();
			file.close();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}

		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream("SystemProducts.txt"));
			Sysproducts = (List<Product>) file.readObject();
			file.close();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}

		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream("SuggestedProducts.txt"));
			suggestedProducts = (List<Product>) file.readObject();
			file.close();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}

		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream("Categories_Products.txt"));
			categoryProducts = (Map<String, List<Product>>) file.readObject();
			file.close();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	public List<Product> RetreiveProduct(String ProductName) {
		List<Product> returnProduct = new ArrayList<>();
		for (Map.Entry<String, List<Product>> entry : categoryProducts.entrySet()) {
			for (Product p : entry.getValue()) {
				if (p.getName().equals(ProductName)) {
					returnProduct.add(p);
				}
			}
		}
		return returnProduct;
	}

	public User RetreiveUser(String username, String password) {
		for (NormalUser user : normalUsers) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return user;
		}
		for (StoreOwner user : Storeowners) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return user;
		}
		for (Administrator user : Admins) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return user;
		}
		return null;
	}

	public void InsertBrand(String bName) {
		brands.add(bName);
	}

	public List<String> RetreiveBrandsNames() {
		return brands;
	}

	public List<String> RetreiveCategoriesNames() {
		List<String> list = new ArrayList<>(categoryProducts.keySet());
		return list;
	}

	public List<Product> RetreiveCategoryProducts(String categoryName) {
		for (Map.Entry<String, List<Product>> list : categoryProducts.entrySet()) {
			if (list.getKey().equals(categoryName)) {
				return list.getValue();
			}
		}
		return null;
	}

	public void InsertUser(User user) {
		if (user instanceof NormalUser) {
			normalUsers.add((NormalUser) user);
		} else if (user instanceof StoreOwner) {
			Storeowners.add((StoreOwner) user);
		} else if (user instanceof Administrator) {
			Admins.add((Administrator) user);
		}
	}

	public void InsertProductToStore(Store store, Product product) {
		product.setID(Integer.toString(ID));
		ID++;
		for (Map.Entry<String, List<Product>> list : categoryProducts.entrySet()) {
			if (list.getKey().equals(product.getCategory())) {
				list.getValue().add(product);
			}
		}
	}

	public List<Product> RetreiveSysProducts() {
		return Sysproducts;
	}

	public void InsertProductToSystem(Product product) {
		Sysproducts.add(product);
		InsertBrand(product.getBrand());
	}

	public void InsertSuggestedProduct(Product product) {
		suggestedProducts.add(product);
	}

	@Override
	public void InsertNewStore(Store store) {
		stores.add(store);
	}

	@Override
	public void provideVoucherCard(String VoucherNo) {
		vouchercards.add(VoucherNo);
	}

	@Override
	public boolean CheckVoucherCard(String VoucherNo) {
		for (String v : vouchercards) {
			if (v.equals(VoucherNo))
				return true;
		}
		return false;
	}

	protected void deleteSuggestedProduct(Product product) {
		suggestedProducts.remove(product);
	}

	@Override
	public List<Product> RetreiveAllProducts() {
		List<Product> list = new ArrayList<>();
		for (Map.Entry<String, List<Product>> entry : categoryProducts.entrySet()) {
			list.addAll(entry.getValue());
		}
		return list;
	}

	@Override
	public List<String> RetreiveStoreNames() {
		List<String> storenames = new ArrayList<>();
		for (Store s : stores) {
			storenames.add(s.getStoreName());
		}
		return storenames;
	}

	@Override
	public List<Product> RetreiveSuggestedProduct() {
		return suggestedProducts;
	}

	@Override
	public void deleteProduct(Product product) {
		for (Map.Entry<String, List<Product>> entry : categoryProducts.entrySet()) {
			if (entry.getValue().contains(product)) {
				entry.getValue().remove(product);
			}
		}
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public List<String> getBrands() {
		return brands;
	}

	public void setBrands(List<String> brands) {
		this.brands = brands;
	}

	public List<Product> getSysproducts() {
		return Sysproducts;
	}

	public void setSysproducts(List<Product> sysproducts) {
		Sysproducts = sysproducts;
	}

	public Map<String, List<Product>> getCategoryProducts() {
		return categoryProducts;
	}

	public void setCategoryProducts(Map<String, List<Product>> categoryProducts) {
		this.categoryProducts = categoryProducts;
	}

	public List<String> getVouchercards() {
		return vouchercards;
	}

	public void setVouchercards(List<String> vouchercards) {
		this.vouchercards = vouchercards;
	}

}